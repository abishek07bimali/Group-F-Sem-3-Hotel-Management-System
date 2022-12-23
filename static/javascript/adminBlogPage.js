const commentContainer = document.getElementById('allComments');
document.getElementById('addComments').addEventListener('click', function (ev) {
   addComment(ev);
});

function addComment(ev) {
    let commentText;
    // , wrapDiv;
    const textBox = document.createElement('div');
    const replyButton = document.createElement('button');
    replyButton.className = 'reply';
    replyButton.innerHTML = 'Reply';
    const likeButton = document.createElement('button');
    likeButton.innerHTML = 'Like';
    likeButton.className = 'likeComment';
    const deleteButton = document.createElement('button');
    deleteButton.innerHTML = 'Delete';
    deleteButton.className = 'deleteComment';
    const wrapDiv = document.createElement('div');
    wrapDiv.className = 'wrapper';
    wrapDiv.style.marginLeft = 0;
    commentText = document.getElementById('newComment').value;
    document.getElementById('newComment').value = '';
    textBox.innerHTML = commentText;
    wrapDiv.append(textBox, replyButton, likeButton, deleteButton);
    commentContainer.appendChild(wrapDiv);
    
}

function hasClass(elem, className) {
    return elem.className.split(' ').indexOf(className) > -1;
}
document.getElementById('allComments').addEventListener('click', function (e) {
    if (hasClass(e.target, 'reply')) {
        const parentDiv = e.target.parentElement;
        const wrapDiv = document.createElement('div');
        wrapDiv.style.marginLeft = (Number.parseInt(parentDiv.style.marginLeft) + 15).toString() + 'px';
        wrapDiv.className = 'wrapper';
        const textArea = document.createElement('textarea');
        textArea.style.marginRight = '20px';
        const addButton = document.createElement('button');
        addButton.className = 'addReply';
        addButton.innerHTML = 'Add';
        const cancelButton = document.createElement('button');
        cancelButton.innerHTML = 'Cancel';
        cancelButton.className='cancelReply';
        wrapDiv.append(textArea, addButton, cancelButton);
        parentDiv.appendChild(wrapDiv);
    } else if(hasClass(e.target, 'addReply')) {
        addComment(e);
    } else if(hasClass(e.target, 'likeComment')) {
         const likeBtnValue = e.target.innerHTML;
         e.target.innerHTML = likeBtnValue !== 'Like' ? Number.parseInt(likeBtnValue) + 1 : 1;
    } else if(hasClass(e.target, 'cancelReply')) {
        e.target.parentElement.innerHTML = '';
    } else if(hasClass(e.target, 'deleteComment')) {
        e.target.parentElement.remove();
    }
});




function deleteRow(rowIndex) {
    // Get a reference to the table
    var table = document.getElementById("blog-table");
  
    // Delete the specified row from the table
    table.deleteRow(rowIndex);
  }
  



// Get a reference to the table
var table = document.getElementById("blog-table");

// Loop through all the rows in the table
for (var i = 0; i < table.rows.length; i++) {
  // Get a reference to the current row
  var row = table.rows[i];

  // Insert a new cell at the end of the row
  var deleteCell = row.insertCell(-1);

  // Create a delete button and set its text
  var deleteButton = document.createElement("del-button");
  deleteButton.innerHTML = "Delete";

  // Attach an event listener to the delete button
  deleteButton.addEventListener("click", function() {
    // Get the index of the row that the delete button belongs to
    var rowIndex = this.parentNode.parentNode.rowIndex;

    // Delete the row
    deleteRow(rowIndex);
  });

  // Add the delete button to the cell
  deleteCell.appendChild(deleteButton);
}



// edit
function editRow(rowIndex) {
    // Get the index of the row that the edit button belongs to
    var rowIndex = this.parentNode.parentNode.rowIndex;
  
    // Change the current URL to the edit page, passing the row index as a query parameter
    window.location = "edit.html?rowIndex=" + rowIndex;
  }

  

  // Get a reference to the table
var table = document.getElementById("blog-table");

// Loop through all the rows in the table
for (var i = 0; i < table.rows.length; i++) {
  // Get a reference to the current row
  var row = table.rows[i];

  // Insert a new cell at the end of the row
  var editCell = row.insertCell(-1);

  // Create an edit button and set its text
  var editButton = document.createElement("button");
  editButton.innerHTML = "Edit";

  // Attach an event listener to the edit button
  editButton.addEventListener("click", editRow);

  // Add the edit button to the cell
  editCell.appendChild(editButton);
}

