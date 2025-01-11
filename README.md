# Kalkulator Operasi Matematika

Proyek ini merupakan implementasi kalkulator yang mendukung berbagai operasi matematika dasar dan lanjutan menggunakan prinsip pemrograman berorientasi objek (OOP). Kalkulator ini dapat melakukan operasi seperti penjumlahan, pengurangan, perkalian, pembagian, pengkuadratan, dan akar kuadrat, dengan desain berbasis antarmuka untuk memudahkan perluasan dan pengelolaan kode.

## Fitur Utama:
- **Penjumlahan (Pertambahan)**: Menjumlahkan dua angka.
- **Pengurangan (Pengurangan)**: Mengurangi angka pertama dengan angka kedua.
- **Perkalian (Perkalian)**: Mengalikan dua angka.
- **Pembagian (Pembagian)**: Membagi angka pertama dengan angka kedua, dengan pengecekan pembagian oleh nol.
- **Akar Kuadrat (AkarKuadrat)**: Menghitung akar kuadrat dari angka pertama.
- **Kuadrat (Kuadrat)**: Menghitung kuadrat dari angka pertama.

## Teknologi:
- **Java**: Proyek ini ditulis dalam bahasa pemrograman Java, menggunakan prinsip OOP seperti **Abstraction**, **Encapsulation**, dan **Polymorphism**.
- **JavaFX**: Digunakan untuk membangun antarmuka pengguna (UI) yang interaktif dan responsif.
- **IntelliJ IDEA**: IDE yang digunakan untuk mengembangkan dan menjalankan proyek ini. IntelliJ IDEA memberikan lingkungan yang ideal untuk pengembangan Java dan JavaFX.

## Struktur Proyek:
- **Operasi**: Antarmuka yang mendefinisikan metode `hitung` yang wajib diimplementasikan oleh semua kelas operasi.
- **Pertambahan**, **Pengurangan**, **Perkalian**, **Pembagian**, **AkarKuadrat**, **Kuadrat**: Kelas-kelas yang mengimplementasikan operasi matematika spesifik sesuai dengan antarmuka `Operasi`.
- **GUI**: Antarmuka pengguna grafis menggunakan JavaFX untuk memudahkan interaksi dengan aplikasi.

## Prinsip OOP yang Diterapkan:
- **Abstraction**: Kelas operasi tersembunyi di balik antarmuka, sehingga pengguna hanya perlu mengetahui metode yang disediakan tanpa harus mengetahui detail implementasi.
- **Polymorphism**: Metode yang sama (`hitung`) dapat memiliki implementasi yang berbeda sesuai dengan jenis operasi yang diinginkan.
- **Encapsulation**: Logika operasi dan penanganan kesalahan tersembunyi di dalam kelas masing-masing.

## Cara Penggunaan:
1. Clone repositori ini ke mesin lokal Anda.
2. Jalankan kelas utama atau buat instance dari kelas operasi yang diinginkan untuk melakukan kalkulasi.
3. Pastikan untuk menangani pengecualian saat menggunakan pembagian untuk menghindari pembagian dengan nol.
4. Anda dapat mengkompilasi dan menjalankan aplikasi menggunakan **IntelliJ IDEA** dengan menambahkan dependensi **JavaFX** pada proyek Anda.

## Lisensi:
Proyek ini dilisensikan di bawah MIT License. Lihat file [LICENSE](LICENSE) untuk informasi lebih lanjut.

