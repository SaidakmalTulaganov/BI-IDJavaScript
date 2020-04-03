var x = prompt("x", "");
function Lx(k, x) {
  if(k == 1){
    return x;
  } else if(k == 0) {
    return 1;
  } else {
    return x * Lx((k - 1), x) - (Math.pow((k - 1), 2) / ((2 * k - 3) * (2 * k - 1))) * Lx((k - 2), x);
  }
}
alert(Lx(5, x));
alert(Lx(7, x));