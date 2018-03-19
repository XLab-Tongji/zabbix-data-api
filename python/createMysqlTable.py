#!/usr/bin/env python

table_names = [
  "agent.ping",
  "vm.memory.size[available]",
  "system.cpu.util[,idle]",
  "system.cpu.util[,interrupt]",
  "system.cpu.util[,iowait]",
  "system.cpu.util[,nice]",
  "system.cpu.util[,softirq]",
  "system.cpu.util[,steal]",
  "system.cpu.util[,system]",
  "system.cpu.util[,user]",
  "vfs.file.cksum[/etc/passwd]",
  "system.cpu.switches",
  "vfs.fs.size[/etc/resolv.conf,free]",
  "vfs.fs.size[/etc/hostname,free]",
  "vfs.fs.size[/etc/hosts,free]",
  "vfs.fs.size[/etc/zabbix/zabbix_agentd.d,free]",
  "vfs.fs.size[/var/lib/zabbix/enc,free]",
  "vfs.fs.size[/var/lib/zabbix/modules,free]",
  "vfs.fs.size[/etc/resolv.conf,pfree]",
  "vfs.fs.size[/etc/hostname,pfree]",
  "vfs.fs.size[/etc/hosts,pfree]",
  "vfs.fs.size[/etc/zabbix/zabbix_agentd.d,pfree]",
  "vfs.fs.size[/var/lib/zabbix/enc,pfree]",
  "vfs.fs.size[/var/lib/zabbix/modules,pfree]",
  "vfs.fs.inode[/etc/resolv.conf,pfree]",
  "vfs.fs.inode[/etc/hostname,pfree]",
  "vfs.fs.inode[/etc/hosts,pfree]",
  "vfs.fs.inode[/etc/zabbix/zabbix_agentd.d,pfree]",
  "vfs.fs.inode[/var/lib/zabbix/enc,pfree]",
  "vfs.fs.inode[/var/lib/zabbix/modules,pfree]",
  "system.swap.size[,free]",
  "system.swap.size[,pfree]",
  "system.boottime",
  "system.localtime",
  "system.hostname",
  "agent.hostname",
  "net.if.in[ip6gre0]",
  "net.if.in[ip6tnl0]",
  "net.if.in[gretap0]",
  "net.if.in[gre0]",
  "net.if.in[sit0]",
  "net.if.in[tunl0]",
  "net.if.in[eth0]",
  "net.if.in[ip6_vti0]",
  "net.if.in[ip_vti0]",
  "system.cpu.intr",
  "kernel.maxfiles",
  "kernel.maxproc",
  "system.users.num",
  "proc.num[]",
  "proc.num[,,run]",
  "net.if.out[ip6gre0]",
  "net.if.out[ip6tnl0]",
  "net.if.out[gretap0]",
  "net.if.out[gre0]",
  "net.if.out[sit0]",
  "net.if.out[tunl0]",
  "net.if.out[eth0]",
  "net.if.out[ip6_vti0]",
  "net.if.out[ip_vti0]",
  "system.cpu.load[percpu,avg1]",
  "system.cpu.load[percpu,avg15]",
  "system.cpu.load[percpu,avg5]",
  "system.uname",
  "system.uptime",
  "vfs.fs.size[/etc/resolv.conf,total]",
  "vfs.fs.size[/etc/hostname,total]",
  "vfs.fs.size[/etc/hosts,total]",
  "vfs.fs.size[/etc/zabbix/zabbix_agentd.d,total]",
  "vfs.fs.size[/var/lib/zabbix/enc,total]",
  "vfs.fs.size[/var/lib/zabbix/modules,total]",
  "vm.memory.size[total]",
  "system.swap.size[,total]",
  "vfs.fs.size[/etc/resolv.conf,used]",
  "vfs.fs.size[/etc/hostname,used]",
  "vfs.fs.size[/etc/hosts,used]",
  "vfs.fs.size[/etc/zabbix/zabbix_agentd.d,used]",
  "vfs.fs.size[/var/lib/zabbix/enc,used]",
  "vfs.fs.size[/var/lib/zabbix/modules,used]",
  "agent.version"
]

'''
CREATE SCHEMA zabbix_data
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

'''


with open('./zabbix.sql', 'w') as file:
    file.write('CREATE SCHEMA zabbix_data')

    for table in table_names:
        file.write('''
CREATE TABLE `%s` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
''' % table)


def transfer(value):
    return value

with open('./zabbix.sql.xml', 'w') as file2:
    for table in table_names:
        file2.write('< table tableName="%s" domainObjectName="%s" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="false" selectByExampleQueryId="false" > </table >\n' % (table, transfer(table)))
