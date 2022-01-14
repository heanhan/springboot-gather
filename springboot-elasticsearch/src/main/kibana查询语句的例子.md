Kibana的使用
```json

# 查看所有的索引 加上 v 会查看更所详细信息
GET /_cat/indices

GET /_cat/indices?v



# 创建简单的索引
PUT chuanjian

# 查看索引下的配置
GET /chuanjian/_settings

#删除索引  成功后会出现  "ackonwledged": true 
DELETE  chuanjian

# 创建一个正是的索引案例 添加映射
# dangdang为自定义的索引名称，
# 7.x版本不用写type，加上type会报错。（这里说的type不是字段里type）
PUT /dangdang
{
  "mappings": {
    "properties": {
      "name":{
        "type": "keyword"
      },
      "price":{
        "type": "double"
      },
      "author":{
        "type": "keyword"
      },
      "descInfo":{
        "type": "text"
      }
    }
  }
}


# 查看某个索引的映射
GET /dangdang/_mapping

# 添加文档  可以使用put 或者post 
# 区别：PUT 后面 文档需要指定id, POST 可以不指定
# POST 和PUT的指定id 后，如果该id对应的文档不存在，则添加，如果存在，则
#  删除原先的文档后添加新的文档。
POST /dangdang/_doc
{
  "name" : "springcloud新手指南",
  "price" : 19.8,
  "author" : "张1三",
  "des" : "技术图书"
}

PUT /dangdang/_doc/2
{
  "name" : "think in java",
  "price" : 29.8,
  "author" : "asc",
  "des" : "好书"
}

# 查询 对应索引的文档所有的内容，默认返回10条数据
GET /dangdang/_search

# 查询指定文档 并分页查询
GET /dangdang/_search
{
  "from": 0,
  "size": 4
  
}

#文档 的按照条件查询,并按照价格排序 降序
GET /dangdang/_search
{
  "query": {
    "match": {
      "name": "think in java"
    }
  },
  "sort": [
    {
      "price": {
        "order": "desc"
      }
    }
  ]
}








```