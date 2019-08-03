# Serverlessパフォーマンス計測対象アプリ

## 概要

Node.js、Python、Java、Goそれぞれの言語において、線形検索およびスリープを行うLambda関数を提供します。

## ビルド＆デプロイ

JavaとGoのコンパイルを行ったのち、Serverless Frameworkでデプロイを行います。

```sh
mvn clean package
docker-compose up
npm install
sls deploy
```

