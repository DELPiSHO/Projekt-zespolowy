
#!/bin/bash

#Checks if IP address file is exists and if is empty
#Creates IP file if does not exist and writes current ip if empty
#Checks if IP has changed and if so updates IP file
#Sends emails if IP in ip file has changed

if [ -f /home/dburczynski/Server/bash/data/publicIPAddress.txt ]
then
        echo "File with public IP address exists!"
        echo "Checking if empty..."
        if [ -s  /home/dburczynski/Server/bash/data/publicIPAddress.txt ]
        then
                echo "File is not empty!"
                curlIPAddress=$(curl ifconfig.me)
                oldIPAddress=$(cat /home/dburczynski/Server/bash/data/publicIPAddress.txt | sed -n 2p )
                echo "Checking if there is new IP..."
                if [ "$curlIPAddress" == "$oldIPAddress" ]
                then
                        echo "The IP has has not changed!"
                else
                        echo "The IP has changed!"
                        echo "Writing to file..."
                        echo "Subject: SSH Server IP update" > /home/dburczynski/Server/bash/data/publicIPAddress.txt
                        echo "$curlIPAddress" >> /home/dburczynski/Server/bash/data/publicIPAddress.txt
                        echo "Port: 22" >> /home/dburczynski/Server/bash/data/publicIPAddress.txt
                        echo "Done"
                        echo "Sending emails..."
                        sendmail dburczynski97@gmail.com < /home/dburczynski/Server/bash/data/publicIPAddress.txt
                        sendmail zhekadeni98@mail.ru < /home/dburczynski/Server/bash/data/publicIPAddress.txt
                        sendmail chmiell.pawel@gmail.com < /home/dburczynski/Server/bash/data/publicIPAddress.txt
                        sendmail maciejglowacki0@gmail.com < /home/dburczynski/Server/bash/data/publicIPAddress.txt     
                        echo "Done"
                fi
        else
                echo "File is empty!"
                echo "Writing new IP to file..."
                echo "Subject: SSH Server IP update" > /home/dburczynski/Server/bash/data/publicIPAddress.txt
                curl ifconfig.me >> /home/dburczynski/Server/bash/data/publicIPAddress.txt
                echo "Port: 2222" >> /home/dburczynski/Server/bash/data/publicIPAddress.txt
                echo "Done"
                echo "Sending emails..."
                sendmail dburczynski97@gmail.com < /home/dburczynski/Server/bash/data/publicIPAddress.txt
                sendmail zhekadeni98@mail.ru < /home/dburczynski/Server/bash/data/publicIPAddress.txt
                sendmail chmiell.pawel@gmail.com < /home/dburczynski/Server/bash/data/publicIPAddress.txt
                sendmail maciejglowacki0@gmail.com < /home/dburczynski/Server/bash/data/publicIPAddress.txt
                echo "Done"
        fi
else
        echo "File is does not exist!"
        echo "Creating new file with current IP..."
        echo "Subject: SSH Server IP update" > /home/dburczynski/Server/bash/data/publicIPAddress.txt
        curl ifconfig.me >> /home/dburczynski/Server/bash/data/publicIPAddress.txt
        echo "Port: 2222" >> /home/dburczynski/Server/bash/data/publicIPAddress.txt
        echo "Done"
        echo "Sending emails..."
        sendmail dburczynski97@gmail.com < /home/dburczynski/Server/bash/data/publicIPAddress.txt
        sendmail zhekadeni98@mail.ru < /home/dburczynski/Server/bash/data/publicIPAddress.txt
        sendmail chmiell.pawel@gmail.com < /home/dburczynski/Server/bash/data/publicIPAddress.txt
        sendmail maciejglowacki0@gmail.com < /home/dburczynski/Server/bash/data/publicIPAddress.txt
        echo "Done"
fi
