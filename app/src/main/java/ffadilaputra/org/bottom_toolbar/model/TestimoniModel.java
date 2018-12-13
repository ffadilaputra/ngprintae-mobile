package ffadilaputra.org.bottom_toolbar.model;

public class TestimoniModel {

	private String nama, durasi, videoRawId;

	public static final TestimoniModel[] testimoni = {
			new TestimoniModel("tersandung", "4:12", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"),
			new TestimoniModel("terjungkir", "3:22", "https://r6---sn-uvu-c336.googlevideo.com/videoplayback?sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&key=yt6&mime=video%2Fmp4&fvip=1&expire=1544563521&ipbits=0&dur=600.096&pl=24&lmt=1544294639505599&ei=4dYPXJShBYS6oAO16pi4CQ&txp=5535432&itag=22&source=youtube&ip=118.174.233.26&ms=au%2Conr&mv=m&mt=1544540657&ratebypass=yes&requiressl=yes&id=o-AF48fA1wHbFuYKp4gaNxZyaUetmw_Bs7OP7ebu_TCTG5&mn=sn-uvu-c336%2Csn-npoe7n7y&mm=31%2C26&c=WEB&initcwndbps=771250&signature=54919AD467971DCACFD06171728CFCAED3C11DD1.1FA8C1642F6CA387852271F2E1345331B9E06EDB&video_id=X4FyFUBTlCU&title=10+MINUTES+OF+DANK+MEMES+-+BEST+MEMES+COMPILATION+A21"),
			new TestimoniModel("terbalik", "4:12", "sample_video_2"),
	};

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getDurasi() {
		return durasi;
	}

	public void setDurasi(String durasi) {
		this.durasi = durasi;
	}

	public String getVideoRawId() {
		return videoRawId;
	}

	public void setVideoRawId(String videoRawId) {
		this.videoRawId = videoRawId;
	}

	public TestimoniModel(String nama, String durasi, String videoRawId) {

		this.nama = nama;
		this.durasi = durasi;
		this.videoRawId = videoRawId;
	}

	@Override
	public String toString() {
		return this.nama;
	}
}
