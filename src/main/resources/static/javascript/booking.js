let error = [];
form.addEventListener('submit', e => {
    validateInputs();

    if (error.length > 0) {
        e.preventDefault();
    }


});

const setError = (element, message) => {
    error.push(true);
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = message;
    inputControl.classList.add('error');
    inputControl.classList.remove('success')
}

const setSuccess = element => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = '';
    inputControl.classList.add('success');
    inputControl.classList.remove('error');
};

const validateInputs = () => {
    error = [];
    const form = document.getElementById('form');
    const FullName = document.getElementById('FullName');
    const Phone = document.getElementById('Phone');
    const RoomType = document.getElementById('RoomType');
    const People = document.getElementById('People');
    const checkInDate = document.getElementById('checkInDate');
    const checkOutDate = document.getElementById('checkOutDate');

    const FullNameValue = FullName.value.trim();
    const PhoneValue = Phone.value.trim();
    const checkInDateValue = checkInDate.value.trim();
    const checkOutDateValue = checkInDate.value.trim();
    debugger;

    if (FullNameValue === '') {
        setError(FullName, 'FullName is required');
    } else {
        setSuccess(FullName);
    }

    if (PhoneValue === '') {
        setError(Phone, 'Phone number is required');
    } else if (PhoneValue.toString().length != 10) {
        setError(Phone, 'Phone number must be of 10 digits');
    } else {
        setSuccess(Phone);
    }
    if (checkInDateValue === '') {
        setError(checkInDate, 'please enter check in date');
    } else {
        setSuccess(checkInDate);
    }

    if (checkOutDateValue === '') {
        setError(checkOutDate, 'please enter check out date');
    } else {
        setSuccess(checkOutDate);
    }
};
