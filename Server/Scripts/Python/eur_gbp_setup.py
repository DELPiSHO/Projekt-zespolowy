import requests
import sys
import json
from pymongo import MongoClient

response = requests.get("https://www.alphavantage.co/query?function=FX_DAILY&from_symbol=EUR&to_symbol=GBP&outputsize=full&apikey=0YA6E8TK5LLURD2A")
if response.status_code != 200:
    sys.exit()

json_data = json.loads(response.text)
timeSeries = json_data['Time Series FX (Daily)']
dates = []
open = []
high = []
low = []
close = []

for k in timeSeries:
    dates.append(k)
    temp = timeSeries[k]
    open.append(temp['1. open'])
    high.append(temp['2. high'])
    low.append(temp['3. low'])
    close.append(temp['4. close'])


client = MongoClient('mongodb://89.69.161.113:27017',username='dburczynski',password='Souvlaki1989', authSource='admin', authMechanism='SCRAM-SHA-256')

db = client.EUR_GBP
for x in range(0, len(dates)):
    EUR_GBP = {
        'date' : dates[x],
        'open' : open[x],
        'low' : low[x],
        'high' : high[x],
        'close' : close[x]
    }
    result = db.Real.insert_one(EUR_GBP)