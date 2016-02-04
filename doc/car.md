### car
| Item      |  type  | description|
| :-------- | --------:| :--: |
|id|int|
|carName|varchar|车型|


### car_details
| Item      |  type  | description|
| :-------- | --------:| :--: |
|id|int|
|carId|int|车型id|
|departName| varchar |配件类型    |
|price|double|价格|

### customer

| Item      |  type  | description|
| :-------- | --------:| :--: |
|id|int|
|userName|varchar|车主|
|carNo|varchar|车牌号|
|mobile|varchar|手机号|
|insurance|varchar|保险
|insuranceStartDate|long|保险开始时间，时间戳
|insuranceEndDate|long|保险到期时间，时间戳
|maintenance|long|下次保养时间

### reparation

| Item      |  type  | description|
| :-------- | --------:| :--: |
|id|int|
|customerName|varchar|车主名
|carNo|varchar|车牌号
|carName|varchar|车型
|createDate|long|创建日期
|price|double|总价
|remark|varchar|备注

### reparation_details

| Item      |  type  | description|
| :-------- | --------:| :--: |
|id|int|
|reparId|int|
|departName|varchar|配件名
|price|double|价格