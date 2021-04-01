# monolithic-bookstore
## 一、用户域
### 1.资源层
#### 1.1 问题
  ```
    # 伪代码
    class AccountResource

    AccountDto getUser(String username);
  ```
* 入参不该是String的基础类型,应该定义一个类,比较好做兼容性升级;
* 返回类型没用用Response包装,且不说前端交互规不规范,自身编码的对称性就过不了。
#### 1.2 调整
  ```
    # 伪代码
    class AccountResource

    Account替换成了AccountDto
  ```
* Account 同时充当dto->内部参数对象->domainEntity->do四种角色,不利于各层逻辑独立演进。
个人认为,对外提供服务要着重考虑兼容;内部参数对象的引入能保证内部逻辑的独立性，便于复用；
do的存在是实现层面的东西，在业务逻辑不该去感知，需要用domainEntity映射，以便防腐。
四种角色的变化率和维度并不一样，不适合合并在一起。