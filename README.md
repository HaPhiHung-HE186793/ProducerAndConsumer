# ProducerAndConsumer
Viết chương trình giải quyết bài toán producer & consumer với các yêu cầu sau: 
Có một message queue chứa các message, cấu trúc message là tùy chọn. Message queue có size giới hạn. 
Một thread đóng vai trò producer: producer định kỳ sẽ tạo ra một message và đưa vào message queue, nếu msgq đã full thì thread sẽ phải đợi cho tới khi msgq không ở trong trạng thái full và tiếp tục tạo message mới đưa vào queue. 
Một thread đóng vai trò consumer: mỗi lần sẽ lấy ra 1 message từ message queue và in message ra màn hình, nếu message queue đang empty thì sẽ phải đợi cho tới khi có message trong queue để xử lý. 
