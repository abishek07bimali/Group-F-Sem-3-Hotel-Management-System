document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        headerToolbar: {
            center: 'addEventButton'
        },
        customButtons: {
            addEventButton: {
                text: 'add event...',
                type:"button",
                click: function() {
                    $('#exampleModal').modal('show');
                    document.getElementById("save").addEventListener("click", save);
                }
            }
        }
    });
    calendar.render();
    function save(){
        var date1=document.getElementById('date').value;
        var date = new Date(date1 + 'T00:00:00');
        var content=document.getElementById('content').value;
        if (!isNaN(date.valueOf())) { // valid?
            calendar.addEvent({
                title: content,
                start: date,
                allDay: true
            });
            alert('Great. Now, update your database...');
        } else {
            alert('Invalid date.');
        }
    }
});
function close1(){
    $('#exampleModal').modal('hide')
}