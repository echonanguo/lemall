# lemall豹速商城

## 开发环境

- 通过docker-compose部署项目所需中间件
  
  ```
  /doc/docker/dev/docker-compose.yml
  /doc/docker/dev/init.sh
  /doc/docker/dev/.env
  ```

- 去mysql创建一个名为的`lemall`数据库，并导入`/doc/sql/lemall.sql`

- 打开minio对象存储web管理端，创建一个名为lemall的Bucket

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

## lemall功能结构说明
