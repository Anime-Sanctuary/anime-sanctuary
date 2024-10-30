# NOTICE
[1次進行] 2024.8/1 ~ 2024.10/14
[2次高度化作業]〜2024.12
https://github.com/Anime-Sanctuary/anime-sanctuary


# Anime Sanctuary

**Anime Sanctuary** は、Five Lights Studio によって開発された、アーティストとファンが交流できるコミュニティプラットフォームです。RESTController をベースに、高速かつ柔軟な API サービスを提供し、テストコードと簡易 CI を通じて機能の無欠性を保証します。

## 主な機能

- **ユーザー認証**: 安全な会員登録とログイン
- **コンテンツ保存**: 気に入ったアートやコンテンツを簡単に保存
- **ダッシュボード管理**: 保存したコンテンツを視覚的に管理
- **コンテンツ探索**: 推薦・検索機能で多様なコンテンツを発見

## 技術スタック

- **バックエンド**: Java、Spring Boot、MySQL、JPA
- **フロントエンド**: JavaScript、HTML、CSS
- **CI とテスト**: 機能の無欠性を維持するためのテストコードと簡易 CI

## インストール手順

1. **リポジトリをクローン**:
   ```bash
   git clone https://github.com/Five-Lights-Studio/anime-sanctuary.git
   cd anime-sanctuary
   ```

2. **ビルド**:
   ```bash
   ./gradlew build
   ```

3. **アプリケーション起動** (ポート 9000):
   ```bash
   java -jar build/libs/anime-sanctuary-0.0.1-SNAPSHOT.jar
   ```

4. **アクセス**: ブラウザで `http://localhost:9000` に移動

## 使用方法

- **会員登録とログイン**: 個別サービスの利用
- **コンテンツ探索と保存**: 投稿を保存し、便利に管理

## 将来的な計画

- **高度な検索**: フィルターオプションの追加
- **コミュニティ機能**: コメントとフォーラム
- **モバイル最適化**: モバイルフレンドリーなインターフェース
