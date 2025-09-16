

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

//   // Create operators ($gt, $gte, $lt, $lte, $in)
//   queryStr = queryStr.replace(/\b(gt|gte|lt|lte|in)\b/g, (match) => `$${match}`);

  // Finding resource
  query = JSON.parse(queryStr);
  console.log("queryStr", query);


  // Select Fields
  if (req.query.select) {
    const fields = req.query.select.split(",").join(" ");
    query.attributes = fields.split(" ");
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

  let sortBy = "-createdAt";
  // Executing query
    if (req.query.sort) {
        sortBy = req.query.sort.split(",").join(" ");
  }
  const results = await model.find().sort(sortBy).select(query.attributes).limit(query.limit).skip(query.offset);
  console.log("results", results);

  res.advancedResults = {
    success: true,
    count: results.length,
    data: results,
  };

  next();
};

module.exports = advancedResults;