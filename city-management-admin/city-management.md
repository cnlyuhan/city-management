---
title: city-management v1.0.0
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
code_clipboard: true
highlight_theme: darkula
headingLevel: 2
generator: "@tarslib/widdershins v4.0.17"

---

# city-management

> v1.0.0

Base URLs:

* <a href="http://test-cn.your-api-server.com">测试环境: http://test-cn.your-api-server.com</a>

# Authentication

# city-management/city-management-admin/user

## POST 登录接口

POST /user/login

> Body 请求参数

```json
{
  "username": "admin",
  "password": "123456"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» username|body|string| 是 |none|
|» password|body|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "msg": "string",
  "data": {
    "id": "string",
    "username": "string",
    "password": "string",
    "auth": 0,
    "status": 0,
    "createTime": "string",
    "updateTime": "string",
    "createUser": "string",
    "updateUser": "string"
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|number|true|none||none|
|» msg|string|true|none||none|
|» data|object|true|none||none|
|»» id|string|true|none||none|
|»» username|string|true|none||none|
|»» password|string|true|none||none|
|»» auth|integer|true|none||none|
|»» status|integer|true|none||none|
|»» createTime|string|true|none||none|
|»» updateTime|string|true|none||none|
|»» createUser|string|true|none||none|
|»» updateUser|string|true|none||none|

## POST 登出接口

POST /user/logout

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "msg": null,
  "data": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|number|true|none||none|
|» msg|null|true|none||none|
|» data|string|true|none||none|

# city-management/city-management-admin/post

## POST 新增文章

POST /post/save

> Body 请求参数

```json
{
  "postContent": "string",
  "postTitle": "string",
  "htmlContent": "string",
  "columnId": "string",
  "createUser": "string",
  "updateUser": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» postContent|body|string¦null| 是 |none|
|» postTitle|body|string| 是 |none|
|» htmlContent|body|string| 是 |none|
|» columnId|body|string| 是 |none|
|» createUser|body|string| 是 |none|
|» updateUser|body|string| 是 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## PUT 编辑文章

PUT /post/put

> Body 请求参数

```json
{
  "id": "string",
  "postContent": "string",
  "postTitle": "string",
  "htmlContent": "string",
  "columnId": "string",
  "createUser": "string",
  "updateUser": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» id|body|string| 是 |none|
|» postContent|body|string| 是 |none|
|» postTitle|body|string| 是 |none|
|» htmlContent|body|string| 是 |none|
|» columnId|body|string| 是 |none|
|» createUser|body|string| 是 |none|
|» updateUser|body|string| 是 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取所有最高层级栏目

GET /post/getColumns

> 返回示例

> 成功

```json
{
  "code": 0,
  "msg": "string",
  "data": [
    {
      "id": "string",
      "name": "string",
      "father_column": "string",
      "createTime": "string",
      "updateTime": "string",
      "createUser": "string",
      "updateUser": "string"
    },
    {
      "id": "string",
      "name": "string",
      "father_column": "string",
      "createTime": "string",
      "updateTime": "string",
      "createUser": "string",
      "updateUser": "string"
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» msg|string|true|none||none|
|» data|[object]|true|none||none|
|»» id|string|true|none||none|
|»» name|string|true|none||none|
|»» father_column|string|true|none||none|
|»» createTime|string|true|none||none|
|»» updateTime|string|true|none||none|
|»» createUser|string|true|none||none|
|»» updateUser|string|true|none||none|

## GET 根据当前栏目获取该栏目下的所有文章

GET /post/page

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|columnId|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 1,
  "msg": null,
  "data": {
    "records": [
      {
        "id": "string",
        "postContent": "string",
        "postTitle": "string",
        "htmlContent": "string",
        "columnId": "string",
        "createTime": "string",
        "updateTime": "string",
        "createUser": "string",
        "updateUser": "string",
        "pageView": "string",
        "columnName": "string"
      },
      {
        "id": "string",
        "postContent": "string",
        "postTitle": "string",
        "htmlContent": "string",
        "columnId": "string",
        "createTime": "string",
        "updateTime": "string",
        "createUser": "string",
        "updateUser": "string",
        "pageView": "string",
        "columnName": "string"
      },
      {
        "id": "string",
        "postContent": "string",
        "postTitle": "string",
        "htmlContent": "string",
        "columnId": "string",
        "createTime": "string",
        "updateTime": "string",
        "createUser": "string",
        "updateUser": "string",
        "pageView": "string",
        "columnName": "string"
      }
    ],
    "total": 24,
    "size": 10,
    "current": 1,
    "order": [],
    "optimizeCountSql": true,
    "hitCount": false,
    "countId": null,
    "maxLimit": null,
    "searchCount": true,
    "pages": 3
  },
  "map": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|number|true|none||none|
|» msg|string|true|none||none|
|» data|object|true|none||none|
|»» records|[string]|true|none||none|
|»» total|integer|true|none||none|
|»» size|integer|true|none||none|
|»» current|integer|true|none||none|
|»» order|[string]|true|none||none|
|»» optimizeCountSql|boolean|true|none||none|
|»» hitCount|boolean|true|none||none|
|»» countId|null|true|none||none|
|»» maxLimit|null|true|none||none|
|»» searchCount|boolean|true|none||none|
|»» pages|integer|true|none||none|
|» map|object|true|none||none|

## GET 根据id获取文章

GET /post/getPost

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 1,
  "msg": null,
  "data": {
    "id": "1413384757047271425",
    "postContent": null,
    "postTitle": "我的第一个html",
    "htmlContent": "<!DOCTYPE html><html><body><h1>My First Heading</h1><p>My first paragraph.<p></body></html> ",
    "columnId": "1397853183287013378",
    "createTime": "2007-05-30 21:31:00",
    "updateTime": "1998-02-24 02:44:29",
    "createUser": "1711676117505581058",
    "updateUser": "1711676117505581058",
    "pageView": 3,
    "columnName": "实验室概况"
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|number|true|none||none|
|» msg|string|true|none||none|
|» data|object|true|none||none|
|»» id|string|true|none||none|
|»» postContent|string|true|none||none|
|»» postTitle|string|true|none||none|
|»» htmlContent|string|true|none||none|
|»» columnId|string|true|none||none|
|»» createTime|string|true|none||none|
|»» updateTime|string|true|none||none|
|»» createUser|string|true|none||none|
|»» updateUser|string|true|none||none|
|»» pageView|number|true|none||文章浏览量|
|»» columnName|string|true|none||栏目的名称|

## DELETE 根据id删除文章

DELETE /post/delete

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 1,
  "msg": null,
  "data": "删除成功"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|number|true|none||none|
|» msg|string|true|none||none|
|» data|object|true|none||none|

# city-management/city-management-admin/column

## POST 新增栏目

POST /column/save

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# city-management/city-management-front

## GET 获取当前父栏目id所有子栏目

GET /front/getColumns

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "msg": "string",
  "data": [
    {
      "id": "string",
      "name": "string",
      "father_column": "string",
      "createTime": "string",
      "updateTime": "string",
      "createUser": "string",
      "updateUser": "string"
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|number|true|none||none|
|» msg|string|true|none||none|
|» data|[object]|true|none||none|
|»» id|string|true|none||none|
|»» name|string|true|none||none|
|»» father_column|string|true|none||none|
|»» createTime|string|true|none||none|
|»» updateTime|string|true|none||none|
|»» createUser|string|true|none||none|
|»» updateUser|string|true|none||none|

## GET 获得所有最高父级栏目

GET /front/getTopColumn

> 返回示例

> 成功

```json
{
  "code": 1,
  "msg": null,
  "data": [
    {
      "id": "1511676117505581058",
      "name": "合作交流",
      "father_column": "0",
      "createTime": "2007-10-25 04:06:41",
      "updateTime": "2016-11-23 19:48:18",
      "createUser": "1611676117505581058",
      "updateUser": "1611676117505581058"
    },
    {
      "id": "1511676117505581058",
      "name": "招生招聘",
      "father_column": "0",
      "createTime": "2007-10-25 04:06:41",
      "updateTime": "2016-11-23 19:48:18",
      "createUser": "1611676117505581058",
      "updateUser": "1611676117505581058"
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|number|true|none||none|
|» msg|string|true|none||none|
|» data|[object]|true|none||none|
|»» id|string|true|none||none|
|»» name|string|true|none||none|
|»» father_column|string|true|none||none|
|»» createTime|string|true|none||none|
|»» updateTime|string|true|none||none|
|»» createUser|string|true|none||none|
|»» updateUser|string|true|none||none|

## GET 根据当前栏目获取该栏目下的所有文章 

GET /front/post/page

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|columnId|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 1,
  "msg": null,
  "data": {
    "records": [
      {
        "id": "string",
        "postContent": "string",
        "postTitle": "string",
        "htmlContent": "string",
        "columnId": "string",
        "createTime": "string",
        "updateTime": "string",
        "createUser": "string",
        "updateUser": "string",
        "pageView": "string",
        "columnName": "string"
      },
      {
        "id": "string",
        "postContent": "string",
        "postTitle": "string",
        "htmlContent": "string",
        "columnId": "string",
        "createTime": "string",
        "updateTime": "string",
        "createUser": "string",
        "updateUser": "string",
        "pageView": "string",
        "columnName": "string"
      },
      {
        "id": "string",
        "postContent": "string",
        "postTitle": "string",
        "htmlContent": "string",
        "columnId": "string",
        "createTime": "string",
        "updateTime": "string",
        "createUser": "string",
        "updateUser": "string",
        "pageView": "string",
        "columnName": "string"
      }
    ],
    "total": 24,
    "size": 10,
    "current": 1,
    "order": [],
    "optimizeCountSql": true,
    "hitCount": false,
    "countId": null,
    "maxLimit": null,
    "searchCount": true,
    "pages": 3
  },
  "map": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|number|true|none||none|
|» msg|string|true|none||none|
|» data|object|true|none||none|
|»» records|[string]|true|none||none|
|»» total|integer|true|none||none|
|»» size|integer|true|none||none|
|»» current|integer|true|none||none|
|»» order|[string]|true|none||none|
|»» optimizeCountSql|boolean|true|none||none|
|»» hitCount|boolean|true|none||none|
|»» countId|null|true|none||none|
|»» maxLimit|null|true|none||none|
|»» searchCount|boolean|true|none||none|
|»» pages|integer|true|none||none|
|» map|object|true|none||none|

## POST 联系我们

POST /front/contact

> Body 请求参数

```json
{
  "name": "string",
  "email": "string",
  "phone": "string",
  "content": "string",
  "createTime": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» name|body|string| 是 |none|
|» email|body|string| 是 |none|
|» phone|body|string| 是 |none|
|» content|body|string| 是 |none|
|» createTime|body|string| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 1,
  "msg": null,
  "data": "添加成功"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|number|true|none||none|
|» msg|string|true|none||none|
|» data|string|true|none||none|

# 数据模型

<h2 id="tocS_Result Copy">Result Copy</h2>

<a id="schemaresult copy"></a>
<a id="schema_Result Copy"></a>
<a id="tocSresult copy"></a>
<a id="tocsresult copy"></a>

```json
{
  "code": 0,
  "msg": "string",
  "data": {}
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|code|number|true|none||none|
|msg|string|true|none||none|
|data|object|true|none||none|

<h2 id="tocS_Column">Column</h2>

<a id="schemacolumn"></a>
<a id="schema_Column"></a>
<a id="tocScolumn"></a>
<a id="tocscolumn"></a>

```json
{
  "id": "string",
  "name": "string",
  "father_column": "string",
  "createTime": "string",
  "updateTime": "string",
  "createUser": "string",
  "updateUser": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|string|true|none||none|
|name|string|true|none||none|
|father_column|string|true|none||none|
|createTime|string|true|none||none|
|updateTime|string|true|none||none|
|createUser|string|true|none||none|
|updateUser|string|true|none||none|

<h2 id="tocS_Result">Result</h2>

<a id="schemaresult"></a>
<a id="schema_Result"></a>
<a id="tocSresult"></a>
<a id="tocsresult"></a>

```json
{
  "code": 0,
  "msg": "string",
  "data": {
    "id": "string",
    "username": "string",
    "password": "string",
    "auth": 0,
    "status": 0,
    "createTime": "string",
    "updateTime": "string",
    "createUser": "string",
    "updateUser": "string"
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|code|number|true|none||none|
|msg|string|true|none||none|
|data|object|true|none||none|
|» id|string|true|none||none|
|» username|string|true|none||none|
|» password|string|true|none||none|
|» auth|integer|true|none||none|
|» status|integer|true|none||none|
|» createTime|string|true|none||none|
|» updateTime|string|true|none||none|
|» createUser|string|true|none||none|
|» updateUser|string|true|none||none|

