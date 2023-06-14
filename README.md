# commission
OSPN社区分佣系统对接
部署步骤
1：克隆代码
2：将skd文件夹里面的ospnBase.jar打包到你的本地仓库
3：启动程序即可
4：注意本地测试可能会报加密异常，原因是因为java8的加密库需要更换，所有测试的时候可以拿到服务器上去测试，或者更换java8里面的加密库
5：部署服务器的时候，sdk文件夹里面的内容需要放到你的架包的同级目录（必须是项目jar的同级目录，否则会加载不到导致启动或者调用报错）
6：修改ospn.properties
          ipConnector=127.0.0.1
          #项目名称
          name=Dapp Demo
          #项目logo
          dappPortrait=http\://hashgame.luckmoney8888.com/im_img/hash.png
          #项目登录地址
          dappUrl=http\://qiangsheng.bingmingff.top/demo/index.html
          #不予更改
          dappCallback=127.0.0.1\:8336
          #不予更改
          ltpNotifyPort=8336
          #项目名称
          dappName=Dapp Demo
          #项目名称
          displayName=Dapp Demo
          #项目logo
          portrait=http\://hashgame.luckmoney8888.com/im_img/hash.png
          #不予更改
          connectorKey=12345678
7：最后修改启动脚本文件start.sh即可
8：启动脚本，即运行代码：sh start.sh
