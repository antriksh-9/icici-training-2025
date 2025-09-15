function foo(){
    return new Promise(function(resolve, reject) {
         setTimeout(function() {
            console.log("foo"   );
                // return "foo";
            resolve("foo");
    }, 5000);   
})
   
}

console.log('starting...');

// asynchronous call
foo()
.then(function (result){
    console.log('result: ' + result);
})
// console.log('result: ' + result);

console.log('done!');