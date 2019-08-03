exports.handler = (event, context, callback) => {
  console.log('started ');

  const number = Number(event.pathParameters.number)

  let number_list = new Array(number);
  for (let i = 0; i < number; i++) {
    number_list[i] = i + 1;
  }
  console.log('list created');

  let result = (number_list.find(e => e == number) == number);
  console.log('number = ' + number + ', result = ' + result);

  setTimeout(() => callback(null, {
    statusCode: 200,
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({result: result})
  }), 100);

}
