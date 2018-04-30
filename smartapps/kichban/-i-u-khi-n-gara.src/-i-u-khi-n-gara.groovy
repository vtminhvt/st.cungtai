definition(
        name: "Điều khiển gara",
        namespace: "KichBan",
        author: "Võ Thanh Minh",
        description: "Kịch bản điều khiển thiết bị dựa vào thói quen, sở thích và mệnh lệnh",
        category: "Safety & Security",
        iconUrl: "https://s3.amazonaws.com/vtmsmartthings/vtms60.png",
        iconX2Url: "https://s3.amazonaws.com/vtmsmartthings/vtms120.png",
        iconX3Url: "https://s3.amazonaws.com/vtmsmartthings/vtms120.png")


preferences 
{
    
    section("Chọn công tắc")
    {
        input("sw1","capability.switch",title:"Nút điều khiển")
    }
}
def installed() 
{
	init()
}

def updated() 
{
init()

}
def init()
{
  	subscribe(sw1,"switch",sw_1) 
}
def sw_1(evt)
{
if (evt.value=="on")
{
		sw1.off()
}
}
