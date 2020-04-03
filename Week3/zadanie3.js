let str1 = '(((()())))',
str2 = '(()((()))))';
console.log(fn(str1));
console.log(fn(str2));
function fn(arg) {
  let arr = arg.split(''),
  count = 0;
  for(let i = 0; i < arr.length; i++) {
    if(arr[i]=='(') {
      count++;
    }
  }
  for(let i = count; i > 0; i--) {
    arr = ff(arr);
  }
  if(arr == null) {
    return true;
  }
  return false;
}
function ff(arg) {
  let start  = -1,
  finish = -1;
  for(let i = arg.length-1; i >= 0; i--) {
    if(arg[i] == '(') {
      start = i;
      console.log(start);
      break;
    }
  }
  for(let i = 0; i < arg.length; i++) {
    if(arg[i] ==')' && i > start) {
      finish = i;
      console.log(finish);
      break;
    }
  }
  if(finish == -1) {
    return arg;
  }
  if((arg.length - 2) == 0) {
    return null;
  }
  let arr = new Array(arg.length-2);
  for(let i = 0, j = 0; i < arr.length; i++, j++) {
    if(j == start || j == finish) {
      j++;
    }
    arr[i] = arg[j];
  }
  let str = '';
  arr.forEach(element => {
    str+=element;  
  });    
  console.log(str);
  return arr;
}