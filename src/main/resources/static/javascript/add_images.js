document.getElementById('add-post-form').addEventListener('submit', function(event) {
    // event.preventDefault(); // prevent the form from being submitted

    // get the form data
    var blogId = document.getElementById('blog-id').value;
    var author = document.getElementById('author').value;

    var content = document.getElementById('content').value;
    var image = document.getElementById('file').value;

    // create a new blog post object
    var newPost = {
        blogId: blogId,
        author: author,

        image: image,
        content: content
    };

    // send the new post to the server (replace with your own code)
    // for example, using fetch:
    fetch('/api/posts', {
        method: 'POST',
        body: JSON.stringify(newPost),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(function(response) {
            return response.json();
        })
        .then(function(data) {
            console.log(data);
        });
});


// Get a reference to the button
var button = document.getElementById("submit");

// Attach an event listener to the button
button.addEventListener("click", function() {
    // Get a reference to the table
    var table = document.getElementById("image-table");

    // Insert a new row at the end of the table
    var newRow = table.insertRow(-1);

    // Get the user's input from the form
    var blogId = document.getElementById('blog-id').value;
    var author = document.getElementById('author-name').value;

    // var content = document.getElementById('content').value;
    var image = document.getElementById('file').value;


    // Insert a new cell at the end of the new row
    var blogCell = newRow.insertCell(-1);
    blogCell.innerHTML = blogId;


    var authorCell = newRow.insertCell(-1);
    authorCell.innerHTML = author;



    // var contentCell = newRow.insertCell(-1);
    // contentCell.innerHTML = content;

    var imageCell = newRow.insertCell(-1);
    imageCell.innerHTML = image;
});










// // Get a reference to the table
// var table = document.getElementById("myTable");

// // Get a list of all the rows in the table
// var rows = table.rows;

// // Loop through the list of rows
// for (var i = 0; i < rows.length; i++) {
//   // Get a reference to the current row
//   var row = rows[i];

//   // Get a list of all the cells in the row
//   var cells = row.cells;

//   // Loop through the list of cells
//   for (var j = 0; j < cells.length; j++) {
//     // Get a reference to the current cell
//     var cell = cells[j];

//     // Get the data from the cell
//     var data = cell.innerHTML;

//     // Do something with the data (e.g., store it in an array or object)
//     console.log(data);
//   }
// }









// html side
// <!DOCTYPE html>
// <html>
// <head>
//   <title>Blog</title>
// </head>
// <body>
//   <h1>Blog</h1>
//   <div id="posts"></div>
// </body>
// </html>


//   fetch('/api/posts')
//   .then(function(response) {
//     return response.json();
//   })
//   .then(function(posts) {
//     var postsHTML = '';
//     for (var i = 0; i < posts.length; i++) {
//       var post = posts[i];
//       postsHTML += '<h2>' + post.title + '</h2>';
//       postsHTML += '<p>by ' + post.author + '</p>';
//       postsHTML += '<p>' + post.content + '</p>';
//     }
//     document.getElementById('posts').innerHTML = postsHTML;
//   });
