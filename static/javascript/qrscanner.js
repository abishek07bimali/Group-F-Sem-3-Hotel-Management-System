var qrcode = new QRCode(document.querySelector(".qrcode"));
qrcode.makeCode("luxury restaurent");
function generateQr() {
  qrcode.makeCode(document.querySelector("input").value);
}