# App tra cứu điểm thi TNTHPT

App có chức năng tra cứu điểm thi TNTHPT 2024 và thống kê phổ điểm các môn trong kỳ thi này với độ chính xác khoảng 85%... App chỉ mang tính học thuật do dữ liệu hiển thị trên app có vào chỗ không đúng với dữ liệu chính xác của Bộ Giáo dục và Đào tạo

## 1. Về phần dữ liệu

App sử dụng dữ liệu thô điểm thi Tốt nghiệp Trung học phổ thông năm 2024, chi tiết [tại đây](https://github.com/anhdung98/diem_thi_2024/). 
File dữ liệu thô là một file .csv có dạng như hình bên dưới
![Ảnh chụp màn hình 2024-07-31 175036](https://github.com/user-attachments/assets/87b28fc2-e83e-4655-a181-c4e0d4a904db)
Sử dụng SQLite để hiển thị dữ liệu dưới dạng bảng như hình
![image](https://github.com/user-attachments/assets/5034a2ae-8111-4c34-aa6e-34d45c4a976d)
Từ dữ liệu đã có, thực hiện các lệnh truy vấn để hiển thị điểm thi và phổ điểm thi các môn.

## 2. Về phần giao diện

a. Tra cứu điểm thi TNTHPT 2024 \
Người dùng nhập số báo danh (gồm 8 số trên tờ giấy dự thi hoặc trên cổng thông tin dự thi của Bộ Giáo dục và Đào tạo)
Hai chữ số đầu tiên của số báo danh là mã Hội đồng thi (tỉnh/thành phố) của thí sinh dự thi, cụ thể:
01 - THÀNH PHỐ HÀ NỘI \
02 - THÀNH PHỐ HỒ CHÍ MINH \
03 - THÀNH PHỐ HẢI PHÒNG \
04 - THÀNH PHỐ ĐÀ NẴNG \
05 - TỈNH HÀ GIANG \
06 - TỈNH CAO BẰNG \
07 - TỈNH LAI CHÂU \
08 - TỈNH LÀO CAI \
09 - TỈNH TUYÊN QUANG \
10 - TỈNH LẠNG SƠN \
11 - TỈNH BẮC KẠN \
12 - TỈNH THÁI NGUYÊN  \
13 - TỈNH YÊN BÁI \
14 - TỈNH SƠN LA \
15 - TỈNH PHÚ THỌ \
16 - TỈNH VĨNH PHÚC \
17 - TỈNH QUẢNG NINH \
18 - TỈNH BẮC GIANG \
19 - TỈNH BẮC NINH \
21 - TỈNH HẢI DƯƠNG \
22 - TỈNH HƯNG YÊN \
23 - TỈNH HÒA BÌNH \
24 - TỈNH HÀ NAM \
25 - TỈNH NAM ĐỊNH \
26 – TỈNH THÁI BÌNH \
27 – TỈNH NINH BÌNH \
28 – TỈNH THANH HÓA \
29 – TỈNH NGHỆ AN \
30 – TỈNH HÀ TĨNH \
31 – TỈNH QUẢNG BÌNH \
32 – TỈNH QUẢNG TRỊ \
33 – TỈNH THỪA THIÊN - HUẾ \
34 – TỈNH QUẢNG NAM \
35 – TỈNH QUẢNG NGÃI \
36 – TỈNH KON TUM \
37 – TỈNH BÌNH ĐỊNH \
38 – TỈNH GIA LAI \
39 – TỈNH PHÚ YÊN \
40 – TỈNH ĐẮK LẮK \
41 – TỈNH KHÁNH HÒA \
42 – TỈNH LÂM ĐỒNG \
43 – TỈNH BÌNH PHƯỚC \
44 – TỈNH BÌNH DƯƠNG \
45 – TỈNH NINH THUẬN \
46 – TỈNH TÂY NINH \
47 – TỈNH BÌNH THUẬN \
48 – TỈNH ĐỒNG NAI \
49 – TỈNH LONG AN \
50 – TỈNH ĐỒNG THÁP \
51 – TỈNH AN GIANG \
52 – TỈNH BÀ RỊA – VŨNG TÀU \
53 – TỈNH TIỀN GIANG\
54 – TỈNH KIÊN GIANG\
55 – THÀNH PHỐ CẦN THƠ\
56 – TỈNH BẾN TRE\
57 – TỈNH VĨNH LONG\
58 – TỈNH TRÀ VINH\
59 – TỈNH SÓC TRĂNG\
60 – TỈNH BẠC LIÊU\
61 – TỈNH CÀ MAU\
62 – TỈNH ĐIỆN BIÊN\
63 – TỈNH ĐĂK NÔNG\
64 – TỈNH HẬU GIANG \
<img src="https://github.com/user-attachments/assets/afb110dd-1716-4dd1-9d03-a514ce591431" alt="drawing" width="250"/>
b. Hiển thị phổ điểm thi các môn trong kì thi TNTHPT 2024 \
Hiển thị phổ điểm bằng cách sử dụng các lệnh truy vấn, tuy nhiên sẽ có một số sai số. Phổ điểm chính xác vui lòng tham khảo của Bộ GD&DT


<img src="https://github.com/user-attachments/assets/88394d82-9506-4f73-84fe-00b3a8274466" alt="drawing" width="250"/>
<img src="https://github.com/user-attachments/assets/8850ed90-6136-4bd2-8c60-dc12d5b75f02" alt="drawing" width="250"/>
<img src="https://github.com/user-attachments/assets/6079fbe1-ac61-4aba-a93a-f9e2c43dd7cc" alt="drawing" width="250"/>
<img src="https://github.com/user-attachments/assets/746830f9-a791-4102-ad2f-9717b0c928f1" alt="drawing" width="250"/>
<img src="https://github.com/user-attachments/assets/3e559ad2-680e-4887-ab1a-9bec7f7369dc" alt="drawing" width="250"/>




