

const advancedResults = (model, include) => async (req, res, next) => {
  let query;

  // Copy req.query
  const reqQuery = { ...req.query };

  // Fields to exclude
  const removeFields = ["select", "sort", "page", "limit", "jbc"];

  // Loop over removeFields and delete them from reqQuery
  removeFields.forEach((param) => delete reqQuery[param]);

  // Create query string
  let queryStr = JSON.stringify(reqQuery);

  // Create operators ($gt, $gte, $lt, $lte, $in)
  queryStr = queryStr.replace(/\b(gt|gte|lt|lte|in)\b/g, (match) => `$${match}`);

  // Finding resource
  query = { where: JSON.parse(queryStr) };

  // If fetching by ID
  if (req.params.id) {
    query = { where: { id: req.params.id } };
  }

  // Select Fields
  if (req.query.select) {
    const fields = req.query.select.split(",").join(" ");
    query.attributes = fields.split(" ");
  }

  // Sort
  if (req.query.sort) {
    const sortBy = req.query.sort.split(",").join(" ");
    query.order = [sortBy];
  }

  // Pagination (only if not fetching by ID)
  if (!req.params.id) {
    const page = parseInt(req.query.page, 10) || 1;
    const limit = parseInt(req.query.limit, 10) || 25;
    const offset = (page - 1) * limit;

    query.offset = offset;
    query.limit = limit;
  }

  // Include associations
  if (include) {
    query.include = include;
  }

  console.log("query", query);

  // Executing query
  const results = await model.findAll(query);

  // Total count for pagination (only if not fetching by ID)
  let totalCount = 1;
  if (!req.params.id) {
    totalCount = await model.count({ where: JSON.parse(queryStr) });
  }

  // Pagination result
  const pagination = {};
  if (!req.params.id) {
    if (query.offset > 0) {
      pagination.prev = {
        page: page - 1,
        limit,
      };
    }

    if (query.offset + query.limit < totalCount) {
      pagination.next = {
        page: page + 1,
        limit,
      };
    }
  }

  res.advancedResults = {
    success: true,
    count: results.length,
    pagination,
    data: results,
  };

  next();
};

module.exports = advancedResults;