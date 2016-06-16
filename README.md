# Calculator4JavaFX
JavaFXによるGUI電卓

![GUI電卓](https://googledrive.com/host/0B1IViKha93aRMmpzemlVcEtTa00/Calculator4JavaFXSS_input.png)

授業「データ構造とアルゴリズムⅡ」におけるプログラミング課題として与えられた電卓プログラムです．
GUI設計にはJavaFXを利用しています．

括弧付きの加算，減算，乗算，除算が行えます．入力は整数に対応しており，
計算精度は[BigDecimal](https://docs.oracle.com/javase/jp/8/docs/api/java/math/BigDecimal.html)より与えられており，
小数点以下の値の丸めは[MathContext.DECIMAL64](https://docs.oracle.com/javase/jp/8/docs/api/java/math/MathContext.html#DECIMAL128)に従った16桁の演算となっています．

## Main.java

メインファイルです．
```
javac Main.java
java Main
```
のコマンドによる実行，または各種IDEよりコンパイル・実行を行って下さい．

## Calculation.java

String型の計算式を引数にとり，その式の計算結果をBigDecimal型で返す，calculateメソッドを定義しています．
式の評価方法には逆ポーランド記法による逐次評価を利用しています．

また，式の評価に利用している木構造データOpクラス，およびNumクラスの定義も行っています．

## CalculatorController.java

GUIコントローラファイルです．各種ボタンとバインドされたメソッド等を記述しています．

## calculator.fxml

Scene builderにより作成したGUI設定ファイルです．
プログラム実行時にはMain.javaと同ディレクトリに置いて下さい．

## keisan.jj

Readerより計算式を受け取り，各種数，および演算子を解釈するパーサの生成を行うJavaCCファイルです．
以下のjavaファイルはJavaCCによって生成したファイルですので，修正するときは直接修正せず，keisan.jjから修正を行い，`javacc`コマンドからjavaファイルの生成を行って下さい．
```
Parser.java
ParseConstanst.java
ParseException.java
ParserTokenManager.java
Token.java
TokenMgrError.java
SimpleCharStream.java
```
