

# TODO

1. proguard file
2. X5WebView 初始化失败
4. 线程池工具类 + RxJava 封装

沉浸式状态栏
bottom menu: dialog fragment

# 技术选型

## 整体框架

MVP

## 图片加载

Glide

Glide Transformations

## 网络请求

RxJava + Retrofit + Okhttp3

## WebView

X5WebView

## 消息总线

EventBus

## 日志

Logger

hugo

## View Inject

Butterknife

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

混合推送


## 热修复

Tinker

## AppConstants

管理所有静态常量

## RxPermission 权限管理

## MultiDex


# Takt

https://github.com/wasabeef/Takt

帧率检测，流畅度检测