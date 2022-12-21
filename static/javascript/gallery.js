var modalEle = document.querySelector(".modal");
var modalImage = document.querySelector(".modalImage");
Array.from(document.querySelectorAll(".myImg")).forEach(item => {
    item.addEventListener("click", event => {
       modalEle.style.display = "block";
       modalImage.src = event.target.src;
    });document.querySelector(".close").addEventListener("click", () => {
        modalEle.style.display = "none";
});});











const images = document.querySelectorAll(".Wrapper-bottom img");
let imgSrc;
// get images src onclick
images.forEach((img) => {
    img.addEventListener("click", (e) => {
        imgSrc = e.target.src;
        imgModal(imgSrc);
        // console.log(imgSrc)
    });
});
let imgModal = (src) => {
    const modal = document.createElement("div");
    modal.setAttribute("class", "modal");
    //add the modal to the main section or the parent element
    document.querySelector(".Main-Wrapper").append(modal);
     //adding image to modal
     const newImage = document.createElement("img");
     newImage.setAttribute("src", src);
    //creating the close button
    const closeBtn = document.createElement("i");
    closeBtn.setAttribute("class", "fas fa-times closeBtn");
    //close function
    closeBtn.onclick = () => {
        modal.remove();
};
modal.append(newImage, closeBtn);

};


