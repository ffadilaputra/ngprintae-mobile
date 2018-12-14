package ffadilaputra.org.bottom_toolbar.model;

public class TestimoniModel {

	private String nama, durasi, videoRawId;

	public static final TestimoniModel[] testimoni = {
			new TestimoniModel("Lezatnya Jajanan GANG AUT ", "4:12", "https://r1---sn-xguxaxjvh-gv8s.googlevideo.com/videoplayback?expire=1544747888&dur=1117.785&ratebypass=yes&fvip=1&nh=%2CIgpwcjAxLnN2bzA1KgkxMjcuMC4wLjE&ipbits=0&lmt=1541106607002814&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cnh%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&requiressl=yes&ei=EKcSXOfAE-jx7ASax5fgBQ&initcwndbps=1106250&source=youtube&itag=22&pl=21&mn=sn-xguxaxjvh-gv8s%2Csn-n8v7knee&ip=176.213.142.220&mm=31%2C29&id=o-ADA0N1EEs2w9uOm9YRSKEHzQFm1g38_60KGZn0L12tkh&signature=4D928D758F8A004090F567054415DAAD7F43EBE2.D35E13E99E7851ED2962F2D67EF1BBCB80F8695F&ms=au%2Crdu&mv=m&mt=1544726164&txp=5431432&key=yt6&mime=video%2Fmp4&c=WEB&video_id=vVCi3hLMUCA&title=Lezatnya+Jajanan+GANG+AUT+-+Froyonion+X+Bogor"),
			new TestimoniModel("Wonderful Indonesia: A Visual Journey through Banyuwangi", "3:22", "https://r1---sn-g5njvh-n8vl.googlevideo.com/videoplayback?requiressl=yes&ip=217.174.179.182&ms=au%2Crdu&mv=m&mt=1544725917&pl=20&id=o-ALLiORovks_NcsN3u15uztpo_X2TL7fqbbRW2Xx6f6sy&mime=video%2Fmp4&mn=sn-g5njvh-n8vl%2Csn-n8v7kn7r&mm=31%2C29&ipbits=0&itag=22&lmt=1476453243067262&key=yt6&fvip=14&ratebypass=yes&c=WEB&nh=%2CIgpwcjAxLnN2bzA1KgkxMjcuMC4wLjE&source=youtube&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cnh%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&expire=1544747689&dur=89.489&ei=SKYSXLLxM8aMyAW7v5jYBQ&initcwndbps=1140000&signature=6F6250BEE1B19BD1B9D22A809FD614F3AAD90708.988BCB6462D19D3CC203B3759B99BB9DEEF7B8A9&video_id=gCaTo5OXD7o&title=Wonderful+Indonesia-+A+Visual+Journey+through+Banyuwangi"),
			new TestimoniModel("PUASA PRODUKTIF SHORT MOVIE", "4:12", "https://r1---sn-jx25uoxu-jb3l.googlevideo.com/videoplayback?source=youtube&pl=24&dur=76.672&fvip=1&expire=1544747979&mt=1544726245&mv=m&ei=a6cSXK7MGYPEowOTlZuACw&id=o-ADXzD3-RLgBzeNORws-N0xLqcACky9p_d_wrA1rBYhBz&ms=au%2Crdu&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&mime=video%2Fmp4&mn=sn-jx25uoxu-jb3l%2Csn-npoeenez&ratebypass=yes&ipbits=0&key=yt6&ip=202.92.201.26&lmt=1527686473355986&requiressl=yes&mm=31%2C29&signature=8EAAA7869ADAD6C294E3C3FC136B5DB153743DD2.D47B8ECF065CCD17F8345F70B122D61853ED39A0&initcwndbps=203750&itag=22&c=WEB&video_id=tOYm0UUrupE&title=PUASA+PRODUKTIF+SHORT+MOVIE+-+FILM+PENDEK+BANGET"),
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
