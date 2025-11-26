#!/bin/bash

echo "========================================"
echo "Remote Health Monitoring System"
echo "Derleme ve Calistirma Scripti"
echo "========================================"
echo ""

# out dizinini oluştur
mkdir -p out

# Java dosyalarını derle
echo "[1/2] Java dosyalari derleniyor..."
javac -d out -sourcepath src/main/java src/main/java/com/rhms/Main.java src/main/java/com/rhms/models/*.java src/main/java/com/rhms/services/*.java

if [ $? -ne 0 ]; then
    echo ""
    echo "HATA: Derleme basarisiz oldu!"
    echo "JDK (Java Development Kit) yuklu oldugundan emin olun."
    echo ""
    exit 1
fi

echo "[2/2] Derleme basarili!"
echo ""
echo "Program calistiriliyor..."
echo "========================================"
echo ""

# Programı çalıştır
java -cp out com.rhms.Main

echo ""
echo "========================================"
echo "Program tamamlandi."

