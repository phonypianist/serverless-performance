package main

import (
  "context"
  "encoding/json"
  "log"
  "strconv"
  "time"
  "github.com/aws/aws-lambda-go/events"
  "github.com/aws/aws-lambda-go/lambda"
)

func search(ctx context.Context, event events.APIGatewayProxyRequest) (events.APIGatewayProxyResponse, error) {
  log.Printf("started ");

  number, _ := strconv.Atoi(event.PathParameters["number"])

  numberList := make([]int, number)
  for i := range numberList {
    numberList[i] = i + 1
  }
  log.Printf("list created");

  result := false
  for _, n := range numberList {
    if n == number {
      result = true
      break
    }
  }
  log.Printf("number = %d, result = %t", number, result);

  time.Sleep(100 * time.Millisecond)

  response := map[string]bool{"result": result}
  jsonBytes, _ := json.Marshal(response)
  return events.APIGatewayProxyResponse{
    StatusCode: 200,
    Headers: map[string]string{"Content-Type": "application/json"},
    Body: string(jsonBytes),
  }, nil
}

func main() {
  log.SetFlags(log.LstdFlags | log.Lmicroseconds)
  lambda.Start(search)
}
