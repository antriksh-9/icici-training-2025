const fs = require('fs').promises;

console.log('starting...');

async function readFile() {
   const data = await fs.readFile('sample.txt', 'utf8')
   console.log('File content:', data); 
}

readFile()
fs.readFile('sample.txt', 'utf8')
  .then(data => {
    console.log('File content:', data); 
    })


console.log('done!');