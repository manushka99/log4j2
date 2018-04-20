const express = require("express");
const fs = require("fs");
const watchman = require("fb-watchman");
const path = require("path");

const app = express();
const client = new watchman.Client();

app.use(express.static("log"));

const filesDir = "./log";
const fileDir1 = "./log/ParallelTest1";

const generateHTML = body => `<html>
<head>Logs</head>
<body>
<ul>
    ${body}
</ul>
</body>
</html>`;

const generateLiItems = files =>
  files.map(file => `<li><a href="${file}">${file}</a></li>`).join("");

app.get("/", function(req, res) {
  fs.readdir(filesDir, (err, files) => {
    const list = generateLiItems(files);
    const html = generateHTML(list);
    res.send(html);
  });
});

// app.get("/ParrallelTest2" + mapIter.next().values, function(req, res) {
// fs.readdir(fileDir1, (err, files) => {
// const list = generateLiItems(files);
// const html = generateHTML(list);
// res.send(html);
// });
// });

app.listen(3000, function() {
  console.log("Example app listening on port 3000!");
});
