CREATE SCHEMA zabbix_data
CREATE TABLE `agent.ping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vm.memory.size[available]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `system.cpu.util[,idle]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `system.cpu.util[,interrupt]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `system.cpu.util[,iowait]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `system.cpu.util[,nice]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `system.cpu.util[,softirq]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `system.cpu.util[,steal]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `system.cpu.util[,system]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `system.cpu.util[,user]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.file.cksum[/etc/passwd]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `system.cpu.switches` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.size[/etc/resolv.conf,free]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.size[/etc/hostname,free]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.size[/etc/hosts,free]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.size[/etc/zabbix/zabbix_agentd.d,free]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.size[/var/lib/zabbix/enc,free]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.size[/var/lib/zabbix/modules,free]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.size[/etc/resolv.conf,pfree]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.size[/etc/hostname,pfree]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.size[/etc/hosts,pfree]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.size[/etc/zabbix/zabbix_agentd.d,pfree]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.size[/var/lib/zabbix/enc,pfree]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.size[/var/lib/zabbix/modules,pfree]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.inode[/etc/resolv.conf,pfree]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.inode[/etc/hostname,pfree]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.inode[/etc/hosts,pfree]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.inode[/etc/zabbix/zabbix_agentd.d,pfree]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.inode[/var/lib/zabbix/enc,pfree]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.inode[/var/lib/zabbix/modules,pfree]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `system.swap.size[,free]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `system.swap.size[,pfree]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `system.boottime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `system.localtime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `system.hostname` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `agent.hostname` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `net.if.in[ip6gre0]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `net.if.in[ip6tnl0]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `net.if.in[gretap0]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `net.if.in[gre0]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `net.if.in[sit0]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `net.if.in[tunl0]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `net.if.in[eth0]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `net.if.in[ip6_vti0]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `net.if.in[ip_vti0]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `system.cpu.intr` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `kernel.maxfiles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `kernel.maxproc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `system.users.num` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `proc.num[]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `proc.num[,,run]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `net.if.out[ip6gre0]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `net.if.out[ip6tnl0]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `net.if.out[gretap0]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `net.if.out[gre0]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `net.if.out[sit0]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `net.if.out[tunl0]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `net.if.out[eth0]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `net.if.out[ip6_vti0]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `net.if.out[ip_vti0]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `system.cpu.load[percpu,avg1]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `system.cpu.load[percpu,avg15]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `system.cpu.load[percpu,avg5]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `system.uname` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `system.uptime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.size[/etc/resolv.conf,total]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.size[/etc/hostname,total]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.size[/etc/hosts,total]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.size[/etc/zabbix/zabbix_agentd.d,total]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.size[/var/lib/zabbix/enc,total]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.size[/var/lib/zabbix/modules,total]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vm.memory.size[total]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `system.swap.size[,total]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.size[/etc/resolv.conf,used]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.size[/etc/hostname,used]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.size[/etc/hosts,used]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.size[/etc/zabbix/zabbix_agentd.d,used]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.size[/var/lib/zabbix/enc,used]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `vfs.fs.size[/var/lib/zabbix/modules,used]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `agent.version` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
