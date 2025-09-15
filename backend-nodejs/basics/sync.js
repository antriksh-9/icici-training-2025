function foo(){
    console.log("foo"   );
    return "foo";
}

console.log('starting...');

// synchronous call
var result = foo();
console.log('result: ' + result);

console.log('done!');