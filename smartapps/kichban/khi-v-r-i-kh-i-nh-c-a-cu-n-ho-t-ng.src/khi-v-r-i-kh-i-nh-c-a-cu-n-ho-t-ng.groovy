definition(
    name: "Khi về/ rời khỏi nhà cửa cuốn hoạt động",
    namespace: "KichBan",
    author: "Võ Thanh Minh",
    description: "Kịch bản điều khiển thiết bị dựa dựa vào định vị GPS của điện thoại",
    category: "Safety & Security",
    iconUrl: "https://s3.amazonaws.com/vtmsmartthings/vtms60.png",
    iconX2Url: "https://s3.amazonaws.com/vtmsmartthings/vtms120.png",
    iconX3Url: "https://s3.amazonaws.com/vtmsmartthings/vtms120.png")
//Test: OK

preferences 
{
    section("Kích hoạt kịch bản")
    {
        input name:"sel",type:"enum", title:"Hoạt động", options: ["on","off"], defaultValue:"off"
    }
    

    section("Chọn nút tác động")
        {
            input("sw1","capability.switch",title:"Nút lên/xuống/dừng")
        }
    
    section("Cảm biến hiện diện")
    {
    	input("presence","capability.presenceSensor",title:"Cảm biến hiện diện")
    }
}
def installed() 
{
    init()
}
def updated() 
{
	unschedule()
   	init()	
}

def init()
{
	
  	subscribe(sw1,"switch",sw_1) 
	subscribe(presence1,"presence",presence_1)
}

def presence_1(evt)
{
	
    
    if (evt.value == "present" && sel == "on")
    {
    
        if (dk1 || dk2)
		{
            sw1.on()
                }
	}	
	else
	{
		//log.debug "timeP= ${timeP}"
	}
}