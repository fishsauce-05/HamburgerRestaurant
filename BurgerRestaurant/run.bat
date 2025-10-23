@echo off
cd src
javac -d ../out com/burgers/Main.java
cd ../out

rem Chạy chương trình và ghi log ra file output.txt
java com.burgers.Main > ../output.txt 2>&1

rem Hiển thị lại kết quả trong CMD
type ../output.txt

rem Mở file log bằng Notepad
notepad ../output.txt

pause
