

# 技术选型

## 整体框架

MVP + Dagger2

## 图片加载

Glide

Glide Transformations

ImageLoader.class 封装图片加载

## 网络请求

RxJava + Retrofit + Okhttp3

## WebView

X5WebView

## 消息总线

EventBus

## 日志

Logger

buildConfigField 保证正式版不打印 log

hugo

## View Inject

Butterknife

## AppConstants

管理所有静态常量

## RxPermission 权限管理

## MultiDex


# Takt

https://github.com/wasabeef/Takt

帧率检测，流畅度检测


# TODO:

## canary

blockcanary

leakcanary


## App

建立 Activity 容器用于一键退出

## Views

### MaterialSearchView

https://github.com/MiguelCatalan/MaterialSearchView

- 各种 BaseAdapter 放在base包中
- Utils: Mobile 添加更多内容，添加更多 util
- 进程保活
- service
- 使用 so 保证安全：把重要常量保存在 so 包中
- 测试Toast是否会导致内存泄露




## push message

整体思路：app 自己实现的推送作为主，第三方推送为辅（更具不同的手机最好使用不同的推送方案）


leancloud 有混合推送的功能 收费

阿里推送 也有混合推送功能 （未来可能收费）

系统厂商推送： 1. 小米推送 2. 华为推送

不收费最佳：1. 小米推送 + 友盟推送

是否可以利用热修复，更具手机载入不同的推送方案。

## 热修复