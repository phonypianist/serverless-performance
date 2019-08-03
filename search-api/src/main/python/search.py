import json
import time
import logging

logger = logging.getLogger()
logger.setLevel(logging.INFO)


def lambda_handler(event, _):
    logger.info('started ')

    number = int(event['pathParameters']['number'])

    number_list = [i for i in range(1, number + 1)]
    logger.info('list created')

    result = number in number_list
    logger.info('number = %d, result = %r', number, result)

    time.sleep(0.1)

    return {
        'statusCode': 200,
        'headers': {
            'Content-Type': 'application/json'
        },
        'body': json.dumps({'result': result})
    }
