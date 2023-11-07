from scapy.all import *

def show_packet(packet):
    print(packet.show())

def capture_packets(packet_list, count):
    sniff(prn=lambda pkt: packet_list.append(pkt), count=count)

count = 50
filt = 'ip'
packet_list = []
if __name__ == '__main__':
    #ICMP, DNS, HTTP, ssh 등 4종 프로토콜 전용 패킷 수집·분석 프로그램 설계 및 구현
    while(True):
        print('>> select options')
        print('1. capture packet')
        print('2. show packet')
        print('3. show filtered packet')
        print(f'4. update packet count now:({count})')
        temp = filt
        if temp == 'port 80':
            temp = 'http'
        elif temp == 'port 22':
            temp = 'dns'
        print('5. clear packet list')
        print('6. escape')
        op = int(input())
        if op == 1:
            capture_packets(packet_list, count)
        elif op == 2:
            for packet in packet_list:
                show_packet(packet)
        elif op == 3:
            print('>> input filter number (1.html, 2.dns 3.icmp, 4.ssh)')
            fn = int(input())
            if fn == 1:
                for packet in packet_list:
                    if packet.haslayer(TCP) and (packet[TCP].dport == 80 or packet[TCP].sport == 80):
                        show_packet(packet)
            elif fn == 2:
                for packet in packet_list:
                    if packet.haslayer(DNS):
                        show_packet(packet)
            elif fn == 3:
                for packet in packet_list:
                    if packet.haslayer(ICMP):
                        show_packet(packet)
            elif fn == 4:
                for packet in packet_list:
                    if packet.haslayer(TCP) and (packet[TCP].dport == 22 or packet[TCP].sport == 22):
                        show_packet(packet)
            else:
                print('not collect input')  
        elif op == 4:
            print('>> input packet count')
            count = int(input())
        elif op == 5:
            packet_list.clear()
        elif op == 6:
            break;
        else:
            print('not correct input')