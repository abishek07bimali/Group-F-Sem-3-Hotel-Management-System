var qrcode = new QRCode(document.querySelector(".qrcode"));
qrcode.makeCode("luxury hotel");
function generateQr() {
  qrcode.makeCode(document.querySelector("input").value);
}