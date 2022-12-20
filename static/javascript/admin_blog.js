document.getElementById('add-post-form').addEventListener('submit', function(event) {
    event.preventDefault(); // prevent the form from being submitted
  
    // get the form data
    var title = document.getElementById('title').value;
    var author = document.getElementById('author').value;
    var content = document.getElementById('content').value;
  
    // create a new blog post object
    var newPost = {
      title: title,
      author: author,
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
