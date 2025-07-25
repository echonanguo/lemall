# lemall豹速商城

## 开发环境

- 通过docker-compose部署项目所需中间件
  
  ```
  /doc/docker/dev/docker-compose.yml
  /doc/docker/dev/init.sh
  /doc/docker/dev/.env
  ```

- 去mysql创建一个名为的`lemall`数据库，并导入`/doc/sql/lemall.sql`

- 打开minio对象存储web管理端，创建一个名为lemall的Bucket，并配置bucket为public

- 在nacos注册中心添加远程配置
  
  ```
  ├─config
  │  ├─admin
  │  │      lemall-admin-dev.yaml
  │  │      lemall-admin-prod.yaml
  │  │
  │  ├─gateway
  │  │      lemall-gateway-dev.yaml
  │  │      lemall-gateway-prod.yaml
  │  │
  │  ├─portal
  │  │      lemall-portal-dev.yaml
  │  │      lemall-portal-prod.yaml
  │  │
  │  └─search
  │          lemall-search-dev.yaml
  │          lemall-search-prod.yaml
  ```

## 项目启动

> lemall项目各个模块启动有先后顺序

1. 网关服务`lemall-gateway`

2. 认证中心`lemall-auth`

3. 后台管理服务`lemall-admin`

4. 前台服务`lemall-portal`

5. 搜索服务`lemall-search`

6. 监控中心`lemall-monitor`

## 日志收集和可视化

> 该项目采用ELK实现日志收集和可视化

在使用ELK日志收集系统之前，需要先启动`mall-admin`、`mall-portal`、`mall-search`三个服务。

1. 打开Kibana web管理界面，找到`Stack Management`

   ![](https://raw.githubusercontent.com/echonanguo/lemall/refs/heads/master/doc/img/Snipaste_2025-06-01_01-22-54.png)

2. 找到`数据视图`

   ![](https://raw.githubusercontent.com/echonanguo/lemall/refs/heads/master/doc/img/Snipaste_2025-06-01_01-23-17.png)

3.创建数据视图

![](https://raw.githubusercontent.com/echonanguo/lemall/refs/heads/master/doc/img/Snipaste_2025-06-01_01-23-34.png)

4. 通过通配符创建视图

   ![](https://raw.githubusercontent.com/echonanguo/lemall/refs/heads/master/doc/img/Snipaste_2025-06-01_01-24-58.png)

5. 按以上步骤继续创建`business error record`

![](https://raw.githubusercontent.com/echonanguo/lemall/refs/heads/master/doc/img/Snipaste_2025-06-01_01-25-14.png)

6. 去查看日志

![](https://raw.githubusercontent.com/echonanguo/lemall/refs/heads/master/doc/img/Snipaste_2025-06-01_01-25-40.png)

7. 选择对应视图即可查看相应日志

   ![](https://raw.githubusercontent.com/echonanguo/lemall/refs/heads/master/doc/img/Snipaste_2025-06-01_01-26-25.png)

## 前端

### 管理

[lemall-admin-web](https://github.com/echonanguo/lemall-admin-web)

### 用户

[lemall-app-web](https://github.com/echonanguo/lemall-app-web)
