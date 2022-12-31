// Get the form and submit button elements
var form = document.getElementById('add-notice-form');
var submitButton = form.querySelector('button[type="submit"]');

// Add an event listener to the submit button
submitButton.addEventListener('click', function(event) {
    // Prevent the form from being submitted to a server
    event.preventDefault();

    // Get the values of the input fields and textarea
    var topic = form.elements['topic-name'].value;
    var date = form.elements['published-date'].value;
    var content = form.elements['content'].value;

    // Create a new XMLHttpRequest object
    var request = new XMLHttpRequest();

    // Set the request method and URL
    request.open('POST', '/upload-notice');

    // Set the request body to the form data
    request.send(JSON.stringify({ topic: topic, date: date, content: content }));

    // Handle the response
    request.onload = function() {
        if (request.status === 200) {
            // Display a success message
            alert('Notice added successfully!');
        } else {
            // Display an error message
            alert('Error adding notice');
        }
    };
});
