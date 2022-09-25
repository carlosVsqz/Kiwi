import ConnectionInstance from './connection-instance';
import {GetJobCategoriesParams, GetJobListMaronryParams, GetJobListParams} from '@store/slices/job';

export const getJobs = (params?: GetJobListParams) => ConnectionInstance.get('posts', { params });

export const getMasonryJobs = (params?: GetJobListMaronryParams) =>
  ConnectionInstance.get('posts-masonry', { params });

export const getMasonryWideJobs = (params?: GetJobListMaronryParams) =>
  ConnectionInstance.get('posts-masonry-wide', { params });

export const getJobCategories = (params?: GetJobCategoriesParams) =>
  ConnectionInstance.get('post-categories', { params });

export const getJobDetail = (id: number) => ConnectionInstance.get('posts/' + id);

//export const getJobDetail = (params?: GetJobListParams) => ConnectionInstance.get('post-jobs', { params });
