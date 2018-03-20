DROP SCHEMA IF EXISTS `zabbix_data`;
CREATE SCHEMA zabbix_data;
USE zabbix_data;

DROP TABLE IF EXISTS `agent_ping`;
CREATE TABLE `agent_ping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vm_memory_size_available_`;
CREATE TABLE `vm_memory_size_available_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `system_cpu_util__idle_`;
CREATE TABLE `system_cpu_util__idle_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `system_cpu_util__interrupt_`;
CREATE TABLE `system_cpu_util__interrupt_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `system_cpu_util__iowait_`;
CREATE TABLE `system_cpu_util__iowait_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `system_cpu_util__nice_`;
CREATE TABLE `system_cpu_util__nice_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `system_cpu_util__softirq_`;
CREATE TABLE `system_cpu_util__softirq_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `system_cpu_util__steal_`;
CREATE TABLE `system_cpu_util__steal_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `system_cpu_util__system_`;
CREATE TABLE `system_cpu_util__system_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `system_cpu_util__user_`;
CREATE TABLE `system_cpu_util__user_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_file_cksum__etc_passwd_`;
CREATE TABLE `vfs_file_cksum__etc_passwd_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `system_cpu_switches`;
CREATE TABLE `system_cpu_switches` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_size__etc_resolv_conf_free_`;
CREATE TABLE `vfs_fs_size__etc_resolv_conf_free_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_size__etc_hostname_free_`;
CREATE TABLE `vfs_fs_size__etc_hostname_free_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_size__etc_hosts_free_`;
CREATE TABLE `vfs_fs_size__etc_hosts_free_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_size__etc_zabbix_zabbix_agentd_d_free_`;
CREATE TABLE `vfs_fs_size__etc_zabbix_zabbix_agentd_d_free_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_size__var_lib_zabbix_enc_free_`;
CREATE TABLE `vfs_fs_size__var_lib_zabbix_enc_free_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_size__var_lib_zabbix_modules_free_`;
CREATE TABLE `vfs_fs_size__var_lib_zabbix_modules_free_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_size__etc_resolv_conf_pfree_`;
CREATE TABLE `vfs_fs_size__etc_resolv_conf_pfree_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_size__etc_hostname_pfree_`;
CREATE TABLE `vfs_fs_size__etc_hostname_pfree_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_size__etc_hosts_pfree_`;
CREATE TABLE `vfs_fs_size__etc_hosts_pfree_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_size__etc_zabbix_zabbix_agentd_d_pfree_`;
CREATE TABLE `vfs_fs_size__etc_zabbix_zabbix_agentd_d_pfree_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_size__var_lib_zabbix_enc_pfree_`;
CREATE TABLE `vfs_fs_size__var_lib_zabbix_enc_pfree_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_size__var_lib_zabbix_modules_pfree_`;
CREATE TABLE `vfs_fs_size__var_lib_zabbix_modules_pfree_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_inode__etc_resolv_conf_pfree_`;
CREATE TABLE `vfs_fs_inode__etc_resolv_conf_pfree_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_inode__etc_hostname_pfree_`;
CREATE TABLE `vfs_fs_inode__etc_hostname_pfree_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_inode__etc_hosts_pfree_`;
CREATE TABLE `vfs_fs_inode__etc_hosts_pfree_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_inode__etc_zabbix_zabbix_agentd_d_pfree_`;
CREATE TABLE `vfs_fs_inode__etc_zabbix_zabbix_agentd_d_pfree_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_inode__var_lib_zabbix_enc_pfree_`;
CREATE TABLE `vfs_fs_inode__var_lib_zabbix_enc_pfree_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_inode__var_lib_zabbix_modules_pfree_`;
CREATE TABLE `vfs_fs_inode__var_lib_zabbix_modules_pfree_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `system_swap_size__free_`;
CREATE TABLE `system_swap_size__free_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `system_swap_size__pfree_`;
CREATE TABLE `system_swap_size__pfree_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `system_boottime`;
CREATE TABLE `system_boottime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `system_localtime`;
CREATE TABLE `system_localtime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `system_hostname`;
CREATE TABLE `system_hostname` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `agent_hostname`;
CREATE TABLE `agent_hostname` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `net_if_in_ip6gre0_`;
CREATE TABLE `net_if_in_ip6gre0_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `net_if_in_ip6tnl0_`;
CREATE TABLE `net_if_in_ip6tnl0_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `net_if_in_gretap0_`;
CREATE TABLE `net_if_in_gretap0_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `net_if_in_gre0_`;
CREATE TABLE `net_if_in_gre0_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `net_if_in_sit0_`;
CREATE TABLE `net_if_in_sit0_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `net_if_in_tunl0_`;
CREATE TABLE `net_if_in_tunl0_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `net_if_in_eth0_`;
CREATE TABLE `net_if_in_eth0_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `net_if_in_ip6_vti0_`;
CREATE TABLE `net_if_in_ip6_vti0_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `net_if_in_ip_vti0_`;
CREATE TABLE `net_if_in_ip_vti0_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `system_cpu_intr`;
CREATE TABLE `system_cpu_intr` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `kernel_maxfiles`;
CREATE TABLE `kernel_maxfiles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `kernel_maxproc`;
CREATE TABLE `kernel_maxproc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `system_users_num`;
CREATE TABLE `system_users_num` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `proc_num__`;
CREATE TABLE `proc_num__` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `proc_num___run_`;
CREATE TABLE `proc_num___run_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `net_if_out_ip6gre0_`;
CREATE TABLE `net_if_out_ip6gre0_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `net_if_out_ip6tnl0_`;
CREATE TABLE `net_if_out_ip6tnl0_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `net_if_out_gretap0_`;
CREATE TABLE `net_if_out_gretap0_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `net_if_out_gre0_`;
CREATE TABLE `net_if_out_gre0_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `net_if_out_sit0_`;
CREATE TABLE `net_if_out_sit0_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `net_if_out_tunl0_`;
CREATE TABLE `net_if_out_tunl0_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `net_if_out_eth0_`;
CREATE TABLE `net_if_out_eth0_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `net_if_out_ip6_vti0_`;
CREATE TABLE `net_if_out_ip6_vti0_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `net_if_out_ip_vti0_`;
CREATE TABLE `net_if_out_ip_vti0_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `system_cpu_load_percpu_avg1_`;
CREATE TABLE `system_cpu_load_percpu_avg1_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `system_cpu_load_percpu_avg15_`;
CREATE TABLE `system_cpu_load_percpu_avg15_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `system_cpu_load_percpu_avg5_`;
CREATE TABLE `system_cpu_load_percpu_avg5_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `system_uname`;
CREATE TABLE `system_uname` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `system_uptime`;
CREATE TABLE `system_uptime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_size__etc_resolv_conf_total_`;
CREATE TABLE `vfs_fs_size__etc_resolv_conf_total_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_size__etc_hostname_total_`;
CREATE TABLE `vfs_fs_size__etc_hostname_total_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_size__etc_hosts_total_`;
CREATE TABLE `vfs_fs_size__etc_hosts_total_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_size__etc_zabbix_zabbix_agentd_d_total_`;
CREATE TABLE `vfs_fs_size__etc_zabbix_zabbix_agentd_d_total_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_size__var_lib_zabbix_enc_total_`;
CREATE TABLE `vfs_fs_size__var_lib_zabbix_enc_total_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_size__var_lib_zabbix_modules_total_`;
CREATE TABLE `vfs_fs_size__var_lib_zabbix_modules_total_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vm_memory_size_total_`;
CREATE TABLE `vm_memory_size_total_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `system_swap_size__total_`;
CREATE TABLE `system_swap_size__total_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_size__etc_resolv_conf_used_`;
CREATE TABLE `vfs_fs_size__etc_resolv_conf_used_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_size__etc_hostname_used_`;
CREATE TABLE `vfs_fs_size__etc_hostname_used_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_size__etc_hosts_used_`;
CREATE TABLE `vfs_fs_size__etc_hosts_used_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_size__etc_zabbix_zabbix_agentd_d_used_`;
CREATE TABLE `vfs_fs_size__etc_zabbix_zabbix_agentd_d_used_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_size__var_lib_zabbix_enc_used_`;
CREATE TABLE `vfs_fs_size__var_lib_zabbix_enc_used_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vfs_fs_size__var_lib_zabbix_modules_used_`;
CREATE TABLE `vfs_fs_size__var_lib_zabbix_modules_used_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `agent_version`;
CREATE TABLE `agent_version` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clock` int(11) DEFAULT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
