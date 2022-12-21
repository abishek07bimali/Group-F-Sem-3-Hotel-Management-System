


const images = document.querySelectorAll(".Wrapper-bottom img");
const modal=document.querySelector(".modal");
const modalImg=document.querySelector(".modalImg");
const close=document.querySelector(".close");


images.forEach((image) => {
   image.addEventListener("click", () => {
       modalImg.src=image.src;
       modal.classList.add("appear");

       close.addEventListener("click",()=>{
        modal.classList.remove("appear");
       });
    });
});



