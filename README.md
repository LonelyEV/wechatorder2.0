# wechatorder2.0
基于maven多模块搭建的springcloud微信点餐系统

# 配置 rancher-server 与 rancher-client 服务器并绑定IP

# 安装 docker
yum install docker

# 配置镜像加速
############################

vim /etc/docker/daemon.json

{
  "registry-mirrors": ["https://fy707np5.mirror.aliyuncs.com"]
}

systemctl daemon-reload
systemctl restart docker


############################


# rancher-server 安装 rancher
sudo docker run -d --restart=unless-stopped -p 8080:8080 rancher/server:stable

# rancher 启动
docker run -d -p 8080:8080 rancher/server
