function foo(callback){
    setTimeout(function() {
        console.log("foo"   );
        // return "foo";
        callback("foo");
    }, 5000);   
}

console.log('starting...');

// asynchronous call
foo(function (result){
    console.log('result: ' + result);
});
// console.log('result: ' + result);

console.log('done!');