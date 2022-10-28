//Lets implement forEach to see how it works

function forEach(items, callback) {
    for (let index = 0; index < items.length; index++) {
        callback(items[index]);
    }
}

// const testCallback = x => 1 + x; 
// console.log(forEach([1,2], testCallback));


// const mockedCallback = null;
// console.log(mockedCallback.mock.results);
// beforeEach
const mockedCallback = jest.fn(x => 10 + x);

xdescribe('sdsd ', () => {
    beforeEach(() => {
        forEach([1, 2], mockedCallback);
    });

    test('Test how many times we call our mocked function ', () => {
        //Using .mock
        expect(mockedCallback.mock.calls.length).toBe(2);
    });

    test('Test the result of the first call of the function to be 11', () => {
        //Using Jest to create a mocked Function
        expect(mockedCallback.mock.results[0].value).toBe(11);
    })
})


// //AfterEach
// afterEach(() => {
//     const mockedCallback = jest.fn(x => 10 + x);
// });