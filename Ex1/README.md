# Design Patterns Java Demo (Complete CLI)

This project demonstrates six design patterns across behavioral, creational and structural categories.
Use the interactive CLI to run demos: `observer`, `strategy`, `factory`, `builder`, `adapter`, `decorator`.

## Build & Run
```bash
javac -d out $(find src -name "*.java")
java -cp out com.example.designpatterns.App
```
sample answer:
C:\Users\PRAVIN\Desktop\design-patterns-java-complete-cli\Ex1\src\main\out>cd ..\java\com\example\designpatterns

C:\Users\PRAVIN\Desktop\design-patterns-java-complete-cli\Ex1\src\main\java\com\example\designpatterns>javac -d ..\..\..\..\out -source 8 -target 8 @sources.txt
warning: [options] bootstrap class path not set in conjunction with -source 8
warning: [options] source value 8 is obsolete and will be removed in a future release
warning: [options] target value 8 is obsolete and will be removed in a future release
warning: [options] To suppress warnings about obsolete options, use -Xlint:-options.
4 warnings

C:\Users\PRAVIN\Desktop\design-patterns-java-complete-cli\Ex1\src\main\java\com\example\designpatterns>cd ..\..\..\..\out

C:\Users\PRAVIN\Desktop\design-patterns-java-complete-cli\Ex1\src\main\out>java com.example.designpatterns.App
Sep 27, 2025 12:20:04 PM com.example.designpatterns.App main
INFO: Design Patterns Demo starting...
Available commands: help, observer, strategy, factory, builder, adapter, decorator, exit
cmd> adapter
Payment ok: true
cmd> decorator
Sep 27, 2025 12:20:15 PM com.example.designpatterns.structural.decorator.LoggingNotifierDecorator send
INFO: Sending to user@example.com using EmailNotifier
Sep 27, 2025 12:20:15 PM com.example.designpatterns.structural.decorator.LoggingNotifierDecorator send
INFO: Sending to user@example.com using EmailNotifier
Sep 27, 2025 12:20:15 PM com.example.designpatterns.creational.factory.EmailNotifier send
INFO: Email sent to user@example.com: Hello from decorated notifier!
cmd> exit
Sep 27, 2025 12:20:21 PM com.example.designpatterns.App main
INFO: Shutting down demo app

C:\Users\PRAVIN\Desktop\design-patterns-java-complete-cli\Ex1\src\main\out>java com.example.designpatterns.App
Sep 27, 2025 12:20:24 PM com.example.designpatterns.App main
INFO: Design Patterns Demo starting...
Available commands: help, observer, strategy, factory, builder, adapter, decorator, exit
cmd> help
Available commands: help, observer, strategy, factory, builder, adapter, decorator, exit
cmd> observer
Sep 27, 2025 12:20:32 PM com.example.designpatterns.behavioral.observer.StockMarket registerObserver
INFO: Observer registered: Trader
Sep 27, 2025 12:20:32 PM com.example.designpatterns.behavioral.observer.StockMarket registerObserver
INFO: Observer registered: Trader
Sep 27, 2025 12:20:32 PM com.example.designpatterns.behavioral.observer.StockMarket registerObserver
INFO: Observer registered: AnalyticsDashboard
Sep 27, 2025 12:20:32 PM com.example.designpatterns.behavioral.observer.Trader onPriceChanged
INFO: Trader Alice notified: AAPL -> 120.50
Sep 27, 2025 12:20:32 PM com.example.designpatterns.behavioral.observer.Trader onPriceChanged
INFO: Trader Bob notified: AAPL -> 120.50
Sep 27, 2025 12:20:32 PM com.example.designpatterns.behavioral.observer.AnalyticsDashboard onPriceChanged
INFO: Analytics: AAPL changed to 120.50 ù computing indicators...
Sep 27, 2025 12:20:32 PM com.example.designpatterns.behavioral.observer.Trader onPriceChanged
INFO: Trader Alice notified: AAPL -> 48.90
Sep 27, 2025 12:20:32 PM com.example.designpatterns.behavioral.observer.Trader onPriceChanged
INFO: Trader Alice decides to BUY AAPL at 48.90
Sep 27, 2025 12:20:32 PM com.example.designpatterns.behavioral.observer.Trader onPriceChanged
INFO: Trader Bob notified: AAPL -> 48.90
Sep 27, 2025 12:20:32 PM com.example.designpatterns.behavioral.observer.Trader onPriceChanged
INFO: Trader Bob decides to BUY AAPL at 48.90
Sep 27, 2025 12:20:32 PM com.example.designpatterns.behavioral.observer.AnalyticsDashboard onPriceChanged
INFO: Analytics: AAPL changed to 48.90 ù computing indicators...
cmd> help
Available commands: help, observer, strategy, factory, builder, adapter, decorator, exit
cmd> strategy
Sep 27, 2025 12:20:40 PM com.example.designpatterns.behavioral.strategy.PricingEngine computeFinalPrice
INFO: Base: 15.48, Final after NoDiscountStrategy: 15.48
No discount final: 15.48
Sep 27, 2025 12:20:40 PM com.example.designpatterns.behavioral.strategy.PricingEngine computeFinalPrice
INFO: Base: 15.48, Final after PercentageDiscountStrategy: 13.16
15% discount final: 13.16
cmd> builder
Built recipe: Masala Dosa by Chef Raju
cmd> adapter
Payment ok: true
cmd> decorator
Sep 27, 2025 12:20:57 PM com.example.designpatterns.structural.decorator.LoggingNotifierDecorator send
INFO: Sending to user@example.com using EmailNotifier
Sep 27, 2025 12:20:57 PM com.example.designpatterns.creational.factory.EmailNotifier send
INFO: Email sent to user@example.com: Hello from decorated notifier!
cmd> exit
Sep 27, 2025 12:21:02 PM com.example.designpatterns.App main
INFO: Shutting down demo app
