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

