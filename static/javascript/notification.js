var box  = document.getElementById('box');
var down = false;


function toggleNotification(){
	if (down) {
		box.style.height  = '0px';
		box.style.opacity = 0;
		down = false;
	}else {
		box.style.height  = '490px';
		box.style.opacity = 1;
		down = true;
	}
}